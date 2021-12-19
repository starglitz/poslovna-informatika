const invoices = [
  { ID: "01", brojFakture: "1", iznosZaPlacanje: 6000, poslovnaGodina: 2021 },
  { ID: "02", brojFakture: "2", iznosZaPlacanje: 7000, poslovnaGodina: 2021 },
  { ID: "03", brojFakture: "3", iznosZaPlacanje: 8000, poslovnaGodina: 2021 },
];

const fetchInvoices = () => {
  return invoices;
};

export const InvoiceService = {
  fetchInvoices,
};
