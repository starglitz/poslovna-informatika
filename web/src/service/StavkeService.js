import axios from "axios";

const baseURL = "http://localhost:8080/api/stavke-izvoda";

async function fetchStavke() {
  const response = await axios.get(baseURL);
  return response.data;
}

export const StavkeService = {
  fetchStavke,
};
