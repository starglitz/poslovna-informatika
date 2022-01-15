import { Table } from "react-bootstrap";
import InvoiceRow from "./InvoiceRow";

const SelectedInvoice = (props) => {
  return (
    <div className="selected-div-invoice">
      <div className="margin inline">
        <span className="align-left margin font-size-1">Izabrana faktura</span>
        <div className="align-left margin inline margin-sm-top"></div>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Broj fakture</th>
            <th>Iznos za placanje</th>
          </tr>
        </thead>
        <tbody>
          <InvoiceRow invoice={props.invoice} key={props.invoice.id} />
        </tbody>
      </Table>
    </div>
  );
};

export default SelectedInvoice;
