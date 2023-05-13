import { Inter } from "next/font/google";
import { Navbar } from "../components/Navbar";
import { useState } from "react";

const inter = Inter({ subsets: ["latin"] });

export default function Home() {
  const [url, setUrl] = useState("");

  return (
    <div className="flex h-screen flex-col">
      <header className="border-b px-12 py-4">
        <Navbar />
      </header>
      <main className="flex-1">
        <div className="flex h-full items-center justify-center">
          <article className="w-1/2 rounded-lg bg-white p-4 text-black shadow-lg">
            <form className="flex flex-col gap-4">
              <label htmlFor="url">Enter a long url to make schmol</label>
              <input
                type="text"
                name="url"
                id="url"
                className="h-14 w-full rounded-lg border p-2"
                onChange={(e) => setUrl(e.target.value)}
              />
              <button
                type="submit"
                onClick={(e) => {
                  e.preventDefault();
                  console.log(url);
                }}
                className="h-14 rounded-lg bg-green-700 p-2 font-bold text-white"
              >
                Click me bitch
              </button>
            </form>
          </article>
        </div>
      </main>
    </div>
  );
}
