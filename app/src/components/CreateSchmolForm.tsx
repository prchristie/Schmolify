import { useState } from "react";

export const CreateSchmolCard = ({
  createSchmolCb,
}: {
  createSchmolCb: (url: string) => any;
}) => {
  const [url, setUrl] = useState("");

  return (
    <article className="w-full rounded-lg bg-white p-4 text-black shadow-lg">
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
            createSchmolCb(url);
            setUrl("");
          }}
          className="h-14 rounded-lg bg-green-700 p-2 text-xl font-bold text-white"
        >
          Schmolify!
        </button>
      </form>
    </article>
  );
};
