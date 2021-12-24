import { Pagination } from "antd";
import debounce from "lodash.debounce";
import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { StavkeService } from "../../service/StavkeService";
import StavkeRow from "./StavkeRow";

const StavkeTable = () => {
  const [stavke, setStavke] = useState([]);

  const [page, setPage] = useState(0);
  const [query, setQuery] = useState("");
  const [totalPages, setTotalPages] = useState(0);

  useEffect(() => {
    fetchStavke(query, page);
  }, [query, page]);

  async function fetchStavke(query, page) {
    const response = await StavkeService.fetchStavke(query, page);
    setStavke(response.content);
    console.log("fetch stavke pozvan");
    setTotalPages(response.totalPages);
  }

  const debouncedFetchStavke = debounce((query) => {
    setQuery(query);
    console.log("kveri je: ", query);
  }, 2000);

  const onSearchInputChange = (e) => {
    debouncedFetchStavke(e.target.value);
  };

  const onPageChange = (e) => {
    setPage(e - 1);
    fetchStavke(query, e - 1);
  };

  return (
    <div class="invoices-div stavke-div">
      <div className="margin inline">
        <span className="align-left margin font-size-2">Stavke izvoda</span>
        <div className="align-left margin inline margin-sm-top"></div>
      </div>

      <div className="search align-right inline font-size-1 margin">
        <span className="margin font-size-1 bold">Search</span> <br />
        <label htmlFor="brojFakture" className="margin">
          svrha placanja:
        </label>
        <input
          type="text"
          name="primalac"
          className="margin"
          onChange={onSearchInputChange}
        />
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
      <div class="margin inline">
        <Pagination
          defaultCurrent={page}
          total={50}
          onChange={onPageChange}
        ></Pagination>
      </div>
    </div>
  );
};

export default StavkeTable;
