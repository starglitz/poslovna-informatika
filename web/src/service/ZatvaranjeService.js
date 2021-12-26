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
  const response = await axios
    .post(baseURL, zatvaranje)
    .catch(function (error) {
      if (error.response) {
        console.log(error.response.status);
      }
    });
}

async function getZatvaranja(faktura, stavka) {
  console.log(faktura.id);
  console.log(stavka.id);
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
