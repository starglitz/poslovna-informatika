import axios from "axios";

const baseURL = "http://localhost:8080/api/izlazne-fakture";

async function fetchInvoices(brojFakture, pageNum) {
  console.log("br fakture", brojFakture);
  console.log("br stranice", pageNum);

  const response = await axios.get(baseURL, {
    params: {
      ...(brojFakture !== 0 ? { brojFakture: brojFakture } : {}),
      ...(pageNum ? { pageNum: pageNum } : {}),
    },
  });
  return response.data;
}

export const InvoiceService = {
  fetchInvoices,
};
