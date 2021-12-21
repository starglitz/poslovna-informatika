import { useEffect, useState } from "react";
import { Dropdown, Table } from "react-bootstrap";
import { InvoiceService } from "../service/InvoiceService";
import InvoiceRow from "./InvoiceRow";

const InvoiceTable = () => {
  const [invoices, setInvoices] = useState([]);

  useEffect(() => {
    fetchInvoices();
  });

  const fetchInvoices = () => {
    setInvoices(InvoiceService.fetchInvoices());
  };

  return (
    <div>
      <div class="margin inline">
        <span class="align-left margin font-size-2">Fakture</span>
        <div class="align-left margin inline margin-sm-top"></div>
        <div class="search align-right inline font-size-1 margin">
          <span class="margin font-size-1 bold">Search</span> <br />
          <label for="ID" class="margin">
            ID:
          </label>
          <input type="text" name="ID" class="margin" />
          <label for="iznos" class="margin">
            Iznos:
          </label>
          <input type="text" name="iznos" class="margin" />
          <label for="poslovnaGodina" class="margin">
            Poslovna godina:
          </label>
          <input type="text" name="poslovnaGodina" class="margin" />
        </div>
      </div>
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Broj fakture</th>
            <th>Iznos za placanje</th>
            <th>Poslovna godina</th>
          </tr>
        </thead>
        <tbody>
          {invoices.map(function (invoice, i) {
            return <InvoiceRow invoice={invoice} key={i} />;
          })}
        </tbody>
      </Table>
      <span class="align-right margin-right">page 1 of 1</span>
    </div>
  );
};

export default InvoiceTable;
