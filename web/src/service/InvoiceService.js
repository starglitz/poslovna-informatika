import axios from "axios";

const baseURL = "http://localhost:8080/api/izlazne-fakture";

async function fetchInvoices(brojFakture, pageNum) {
  const response = await axios.get(baseURL, {
    params: {
      ...(brojFakture !== 0 ? { brojFakture: brojFakture } : {}),
      ...(pageNum ? { pageNum: pageNum } : {}),
    },
  });
  return response.data;
}

async function getPdf(poslovniPartner) {
  const response = await axios.get(baseURL + "/pdf", {
    responseType: "arraybuffer",
    params: { poslovniPartnerId: poslovniPartner.id },
  });

  console.log("getPdf called", response);
  return response.data;
}

export const InvoiceService = {
  fetchInvoices,
  getPdf,
};
