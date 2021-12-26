import { Button, Pagination } from "antd";
import { useEffect, useState } from "react";
import { Table, Toast } from "react-bootstrap";
import { ZatvaranjeService } from "../../service/ZatvaranjeService";
import ZatvaranjeRow from "./ZatvaranjeRow";

const ZatvaranjeFaktureTable = (props) => {
  const [zatvaranje, setZatvaranje] = useState([]);

  const [iznos, setIznos] = useState(0);

  const [showToast, setShowToast] = useState(false);
  const [toastMessage, setToastMessage] = useState("");
  const toggleShowToast = (show, message) => {
    console.log(show);
    console.log(message);
    if (show) {
      setToastMessage(message);
    }
    setShowToast(show);
  };

  useEffect(() => {
    fetchZatvaranje();
  }, [toastMessage, props.invoice, props.stavka]);

  async function fetchZatvaranje() {
    const response = await ZatvaranjeService.getZatvaranja(
      props.invoice,
      props.stavka
    );

    console.log(response);
    setZatvaranje(response);
  }

  const onInputChange = (e) => {
    setIznos(e.target.value);
  };

  async function zatvoriFakturu() {
    const zatvaranjeFakture = {
      iznos: iznos,
      stavkaIzvoda: props.stavka,
      faktura: props.invoice,
    };

    if (iznos <= 0) {
      toggleShowToast(true, "Iznos uplate mora biti veci od 0");
    } else if (props.invoice.zatvorena) {
      toggleShowToast(true, "Izabrana faktura je vec zatvorena");
    } else {
      await ZatvaranjeService.zatvoriFakturu(zatvaranjeFakture);
      console.log(zatvaranjeFakture);
      setIznos(0);
    }
  }

  return (
    <div>
      <div className="display-block zatvaranje-table">
        <div className="margin inline">
          <span className="align-left margin font-size-2">
            Zatvaranje fakture
          </span>

          {props.invoice.id && props.stavka.id && (
            <div className="font-size-1">
              <p className="stavke-div margin-right"> unesite iznos: </p>
              <input
                type="number"
                class="margin-right"
                onChange={onInputChange}
              ></input>
              <Button onClick={zatvoriFakturu}>zatvori fakturu</Button>
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
      </div>

      <div class="error-toast">
        <Toast show={showToast} onClose={() => toggleShowToast(false)}>
          <Toast.Header>
            <img
              src="holder.js/20x20?text=%20"
              className="rounded me-2"
              alt=""
            />
            <strong className="me-auto">Greska</strong>
          </Toast.Header>
          <Toast.Body>{toastMessage}</Toast.Body>
        </Toast>
      </div>
    </div>
  );
};

export default ZatvaranjeFaktureTable;
