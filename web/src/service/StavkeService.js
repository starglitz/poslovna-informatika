import axios from "axios";

const baseURL = "http://localhost:8080/api/stavke-izvoda";

async function fetchStavke(svrhaPlacanja, pageNum) {
  const response = await axios.get(baseURL, {
    params: {
      ...(svrhaPlacanja !== "" ? { svrhaPlacanja: svrhaPlacanja } : {}),
      ...(pageNum ? { pageNum: pageNum } : {}),
    },
  });
  return response.data;
}

export const StavkeService = {
  fetchStavke,
};
