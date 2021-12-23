import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { StavkeService } from "../../service/StavkeService";
import StavkeRow from "./StavkeRow";

const StavkeTable = () => {
  const [stavke, setStavke] = useState([]);

  useEffect(() => {
    fetchStavke();
  }, []);

  async function fetchStavke() {
    const response = await StavkeService.fetchStavke();
    console.log(response);
    setStavke(response);
  }

  return (
    <div class="invoices-div stavke-div">
      <div className="margin inline">
        <span className="align-left margin font-size-2">Stavke izvoda</span>
        <div className="align-left margin inline margin-sm-top"></div>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Broj stavke</th>
            <th>Iznos za placanje</th>
            <th>Duznik</th>
            <th>Svrha placanja</th>
            <th>Primalac</th>
          </tr>
        </thead>
        <tbody>
          {stavke.map((stavka) => (
            <StavkeRow stavka={stavka} key={stavka.id} />
          ))}
        </tbody>
      </Table>
      <span className="align-right margin-right">page 1 of 1</span>
    </div>
  );
};

export default StavkeTable;
