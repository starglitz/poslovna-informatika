import axios from "axios";

const baseURL = "http://localhost:8080/api/zatvaranje-fakture";

async function fetchZatvaranje(pageNum) {
  const response = await axios.get(baseURL, {
    params: {
      ...(pageNum ? { pageNum: pageNum } : {}),
    },
  });
  console.log(response.data);
  return response.data;
}

export const ZatvaranjeService = {
  fetchZatvaranje,
};
