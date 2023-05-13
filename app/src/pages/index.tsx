import { Navbar } from "../components/Navbar";
import { MouseEvent, useState } from "react";
import { useMutation } from "@tanstack/react-query";

import schmolService, { Schmol } from "../services/schmol";

export default function Home() {
  const [url, setUrl] = useState("");
  const [createdSchmol, setCreatedSchmol] = useState<Schmol | null>(null);
  const createSchmolMutation = useMutation({
    mutationFn: schmolService.create,
  });

  const createNewSchmol = async () => {
    const schmol = await createSchmolMutation.mutateAsync(url);
    setUrl("");
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
            <article className="w-1/2 rounded-lg bg-white p-4 text-black shadow-lg">
              <form className="flex flex-col gap-4">
                <label htmlFor="url">Enter a long url to make schmol</label>
                <input
                  type="text"
                  name="url"
                  id="url"
                  className="h-14 w-full rounded-lg border p-2"
                  onChange={(e) => setUrl(e.target.value)}
                  value={url}
                />
                <button
                  type="submit"
                  onClick={(e) => {
                    e.preventDefault();
                    createNewSchmol();
                  }}
                  className="h-14 rounded-lg bg-green-700 p-2 font-bold text-white"
                >
                  Click me bitch
                </button>
              </form>
            </article>
          )}
          {createdSchmol != null &&
            `You created a schmol bitch. Go to ${
              location.protocol + "//" + location.host + "/" + createdSchmol.id
            }`}
        </div>
      </main>
    </div>
  );
}
