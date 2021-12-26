import axios from "axios";

const baseURL = "http://localhost:8080/api/dnevno-stanje";

async function uploadDnevnoStanje(dnevnoStanjeFajl) {
  const response = await axios.post(baseURL, dnevnoStanjeFajl);
  return response.data;
}

export const DnevnoStanjeService = {
  uploadDnevnoStanje,
};
