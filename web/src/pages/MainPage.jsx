import { useEffect } from "react";
import InvoiceTable from "../components/invoice/InvoiceTable";
import StavkeTable from "../components/stavke/StavkeTable";

const MainPage = () => {
  useEffect(() => {
    console.log("on load");
  });

  return (
    <div>
      <div class="table-wrapper">
        <InvoiceTable></InvoiceTable>
        <StavkeTable></StavkeTable>
      </div>
    </div>
  );
};

export default MainPage;
