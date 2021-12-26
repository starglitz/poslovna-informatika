import axios from "axios";

const baseURL = "http://localhost:8080/api/zatvaranje-fakture";

async function fetchZatvaranje(pageNum) {
  const response = await axios.get(baseURL, {
    params: {
      ...(pageNum ? { pageNum: pageNum } : {}),
    },
  });
  return response.data;
}

async function zatvoriFakturu(zatvaranje) {
  return await axios.post(baseURL, zatvaranje);
}

async function getZatvaranja(faktura, stavka) {
  const response = await axios.get(baseURL, {
    params: {
      ...(faktura.id ? { fakturaId: faktura.id } : {}),
      ...(stavka.id ? { stavkaId: stavka.id } : {}),
    },
  });

  return response.data;
}

export const ZatvaranjeService = {
  fetchZatvaranje,
  zatvoriFakturu,
  getZatvaranja,
};
