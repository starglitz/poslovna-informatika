import axios from "axios";

const baseURL = "http://localhost:8080/api/poslovni-partneri";

async function fetchPartneri() {
  const response = await axios.get(baseURL);
  return response.data;
}

export const PartneriService = {
  fetchPartneri,
};
