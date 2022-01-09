import axios from "axios";

const baseURL = "http://localhost:8080/api/dnevna-stanja";

async function uploadDnevnoStanje(dnevnoStanjeFajl) {
  var formData = new FormData();
  formData.append("fajl", dnevnoStanjeFajl);

  const response = await axios.post(baseURL + "/upload", formData);
  return response.data;
}

export const DnevnoStanjeService = {
  uploadDnevnoStanje,
};
