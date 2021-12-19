import { useEffect } from "react";
import InvoiceRow from "../components/InvoiceRow";
import InvoiceTable from "../components/InvoiceTable";
import PaymentSlip from "../components/PaymentSlip";
import SelectedInvoice from "../components/SelectedInvoice";

const MainPage = () => {
  useEffect(() => {
    console.log("on load");
  });

  return (
    <div>
      <InvoiceTable></InvoiceTable>
      <SelectedInvoice></SelectedInvoice>
      <PaymentSlip></PaymentSlip>
    </div>
  );
};

export default MainPage;
