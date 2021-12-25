import { useEffect, useState } from "react";
import InvoiceTable from "../components/invoice/InvoiceTable";
import SelectedInvoice from "../components/invoice/SelectedInvoice";
import SelectedStavka from "../components/stavke/SelectedStavka";
import StavkeTable from "../components/stavke/StavkeTable";
import ZatvaranjeFaktureTable from "../components/zatvaranje-fakture/ZatvaranjeFaktureTable";

const MainPage = () => {
  const [selectedInvoice, setSelectedInvoice] = useState({});
  const [selectedStavka, setSelectedStavka] = useState({});

  const onSelectedInvoiceChange = (invoice) => {
    setSelectedInvoice(invoice);
  };
  const onSelectedStavkaChange = (stavka) => {
    setSelectedStavka(stavka);
  };

  useEffect(() => {}, [selectedInvoice, selectedStavka]);

  return (
    <div>
      <div class="table-wrapper">
        <InvoiceTable
          onSelectedInvoiceChange={onSelectedInvoiceChange}
        ></InvoiceTable>
        <StavkeTable
          onSelectedStavkaChange={onSelectedStavkaChange}
        ></StavkeTable>
      </div>
      <SelectedInvoice invoice={selectedInvoice}></SelectedInvoice>
      <SelectedStavka stavka={selectedStavka}></SelectedStavka>
      <ZatvaranjeFaktureTable
        invoice={selectedInvoice}
        stavka={selectedStavka}
      ></ZatvaranjeFaktureTable>
    </div>
  );
};

export default MainPage;
