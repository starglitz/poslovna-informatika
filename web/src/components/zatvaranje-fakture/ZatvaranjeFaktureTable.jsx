import { Button, Pagination } from "antd";
import { useEffect, useState } from "react";
import { Table } from "react-bootstrap";
import { ZatvaranjeService } from "../../service/ZatvaranjeService";
import ZatvaranjeRow from "./ZatvaranjeRow";

const ZatvaranjeFaktureTable = (props) => {
  const [zatvaranje, setZatvaranje] = useState([]);

  const [page, setPage] = useState(0);
  const [totalElements, setTotalElements] = useState(0);

  useEffect(() => {
    fetchZatvaranje();
  }, [page]);

  async function fetchZatvaranje(page) {
    const response = await ZatvaranjeService.fetchZatvaranje(page);
    setZatvaranje(response.content);
    setTotalElements(response.totalElements);
  }

  const onPageChange = (e) => {
    setPage(e - 1);
    fetchZatvaranje(e - 1);
  };

  return (
    <div className="display-block zatvaranje-table">
      <div className="margin inline">
        <span className="align-left margin font-size-2">
          Zatvaranje fakture
        </span>

        {props.invoice.id && props.stavka.id && (
          <div className="font-size-1">
            <p className="stavke-div margin-right"> unesite iznos: </p>
            <input type="number" class="margin-right"></input>
            <Button>zatvori fakturu</Button>
          </div>
        )}

        <div className="align-left margin inline margin-sm-top"></div>
      </div>

      <Table striped bordered hover>
        <thead>
          <tr>
            <th>ID</th>
            <th>Iznos</th>
          </tr>
        </thead>
        <tbody>
          {zatvaranje.map((zatvaranje) => (
            <ZatvaranjeRow zatvaranje={zatvaranje} key={zatvaranje.id} />
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

export default ZatvaranjeFaktureTable;
