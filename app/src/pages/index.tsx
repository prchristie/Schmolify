import { Navbar } from "../components/Navbar";
import { MouseEvent, SetStateAction, useState } from "react";
import {
  hashQueryKey,
  QueryKey,
  useMutation,
  useQuery,
  useQueryClient,
} from "@tanstack/react-query";

import schmolService, { Schmol, schmolIdToUrl } from "../services/schmol";
import { CreateSchmolCard as CreateSchmolForm } from "../components/CreateSchmolForm";

export default function Home() {
  const createSchmolMutation = useMutation({
    mutationFn: schmolService.create,
  });
  const queryClient = useQueryClient();
  const getSchmols = useQuery(["schmols"], schmolService.getAll);

  const createNewSchmol = async (url: string) => {
    await createSchmolMutation.mutateAsync(url, {
      onSuccess: () => queryClient.invalidateQueries(["schmols"]),
    });
  };

  return (
    <div className="flex h-screen flex-col">
      <header className="border-b px-12 py-4">
        <Navbar />
      </header>
      <main className="flex-1">
        <div className="flex h-full items-center justify-around">
          <div className="w-1/3">
            <CreateSchmolForm createSchmolCb={createNewSchmol} />
          </div>
          <ul>
            {getSchmols.data?.map((schmol) => (
              <li
                key={schmol.id}
                onClick={() => {
                  navigator.clipboard.writeText(schmolIdToUrl(schmol.id));
                }}
              >
                {schmolIdToUrl(schmol.id)}: {schmol.url}
              </li>
            ))}
          </ul>
        </div>
      </main>
    </div>
  );
}
