import { useEffect, useState } from "react";
import DownloadPdf from "../components/invoice/DownloadPdf";
import InvoiceTable from "../components/invoice/InvoiceTable";
import SelectedInvoice from "../components/invoice/SelectedInvoice";
import SelectedStavka from "../components/stavke/SelectedStavka";
import StavkeTable from "../components/stavke/StavkeTable";
import UploadFile from "../components/upload/UploadFile";
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
        onSelectedInvoiceChange={onSelectedInvoiceChange}
      ></ZatvaranjeFaktureTable>
      <DownloadPdf></DownloadPdf>
      <UploadFile></UploadFile>
    </div>
  );
};

export default MainPage;
