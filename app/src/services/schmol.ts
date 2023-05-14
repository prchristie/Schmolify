import axios from "axios";

const baseUrl = "http://localhost:8080/api/v1/schmol";

export type Schmol = {
  id: string;
  url: string;
};

const get = async (id: string | undefined): Promise<Schmol> => {
    const res = await fetch(`${baseUrl}/${id}`);
  return (await res.json()).schmol as Schmol;
};

const create = async (url: string): Promise<Schmol> => {
  const res = await axios.post(baseUrl, { url });
  return res.data.schmol as Schmol;
};

export default { get, create };
