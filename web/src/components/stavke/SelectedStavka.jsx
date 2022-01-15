import { Table } from "react-bootstrap";
import StavkeRow from "./StavkeRow";

const SelectedStavka = (props) => {
  return (
    <div className="selected-div-stavka">
      <div className="margin inline">
        <span className="align-left margin font-size-1">Izabrana stavka</span>
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
          <StavkeRow stavka={props.stavka} key={props.stavka.id} />
        </tbody>
      </Table>
    </div>
  );
};

export default SelectedStavka;
