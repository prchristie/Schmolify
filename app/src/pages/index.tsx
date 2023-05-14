import { Navbar } from "../components/Navbar";
import { MouseEvent, SetStateAction, useState } from "react";
import { useMutation } from "@tanstack/react-query";

import schmolService, { Schmol } from "../services/schmol";
import { CreateSchmolCard as CreateSchmolForm } from "../components/CreateSchmolForm";

export default function Home() {
  const [createdSchmol, setCreatedSchmol] = useState<Schmol | null>(null);
  const createSchmolMutation = useMutation({
    mutationFn: schmolService.create,
  });

  const createNewSchmol = async (url: string) => {
    const schmol = await createSchmolMutation.mutateAsync(url);
    setCreatedSchmol(schmol);
  };

  return (
    <div className="flex h-screen flex-col">
      <header className="border-b px-12 py-4">
        <Navbar />
      </header>
      <main className="flex-1">
        <div className="flex h-full items-center justify-center">
          {createdSchmol == null && (
            <CreateSchmolForm createSchmolCb={createNewSchmol} />
          )}
          {createdSchmol != null &&
            `You created a schmol bitch. Go to ${
              location.protocol +
              "//" +
              location.host +
              "/go/" +
              createdSchmol.id
            }`}
        </div>
      </main>
    </div>
  );
}
