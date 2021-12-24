import { Pagination } from "antd";
import debounce from "lodash.debounce";
import { useEffect, useState } from "react";
import { Dropdown, Table } from "react-bootstrap";
import { InvoiceService } from "../../service/InvoiceService";
import InvoiceRow from "./InvoiceRow";

const InvoiceTable = () => {
  const [invoices, setInvoices] = useState([]);

  const [page, setPage] = useState(0);
  const [query, setQuery] = useState("");
  const [totalElements, setTotalElements] = useState(0);

  useEffect(() => {
    fetchInvoices(query, page);
  }, [query, page]);

  async function fetchInvoices(query, page) {
    const response = await InvoiceService.fetchInvoices(query, page);
    console.log(response);
    setInvoices(response.content);
    setTotalElements(response.totalElements);
    console.log(response.totalPages);
  }

  const debouncedFetchInvoices = debounce((query) => {
    setQuery(query);
  }, 2000);

  const onSearchInputChange = (e) => {
    debouncedFetchInvoices(e.target.value);
  };

  const onPageChange = (e) => {
    setPage(e - 1);
    fetchInvoices(query, e - 1);
  };

  return (
    <div className="invoices-div">
      <div className="margin inline">
        <span className="align-left margin font-size-2">Fakture</span>
        <div className="align-left margin inline margin-sm-top"></div>
        <div className="search align-right inline font-size-1 margin">
          <span className="margin font-size-1 bold">Search</span> <br />
          <label htmlFor="brojFakture" className="margin">
            broj fakture:
          </label>
          <input
            type="text"
            name="brojFakture"
            className="margin"
            onChange={onSearchInputChange}
          />
        </div>
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
          {invoices.map((invoice) => (
            <InvoiceRow invoice={invoice} key={invoice.id} />
          ))}
        </tbody>
      </Table>
      <div class="margin inline">
        <Pagination
          defaultCurrent={page}
          total={totalElements}
          onChange={onPageChange}
        ></Pagination>
      </div>
    </div>
  );
};

export default InvoiceTable;
