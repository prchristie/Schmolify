import axios from "axios";

const baseUrl = "/api/v1/schmol";

export type Schmol = {
    id: string;
    url: string;
}

export const getSchmol = async (id: string): Promise<Schmol> => {
    const res = await axios.get(`${baseUrl}/${id}`);
    return res.data;
}