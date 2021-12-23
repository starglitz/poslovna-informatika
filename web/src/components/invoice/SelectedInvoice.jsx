import Button from "@restart/ui/esm/Button";
import { Form } from "react-bootstrap";

const SelectedInvoice = (props) => {
  return (
    <div class="align-left bg-gray selected-invoice">
      <div class="padding bold"> Izabrana faktura </div>
      <div class="invoice-form">
        <table class="padding">
          <tr class="padding">
            <td class="padding">
              <label for="ID">ID:</label>
            </td>
            <td class="padding">
              <input type="text" name="ID" defaultValue="1" readOnly />
            </td>
          </tr>
          <tr class="padding">
            <td class="padding">
              <label for="iznos">Iznos:</label>
            </td>
            <td class="padding">
              <input type="text" name="iznos" defaultValue="7000" readOnly />
            </td>
          </tr>
          <tr class="padding">
            <td class="padding">
              <label for="poslovnaGodina">Poslovna godina:</label>
            </td>
            <td class="padding">
              <input
                type="text"
                name="poslovnaGodina"
                defaultValue="2021"
                readOnly
              />
            </td>
          </tr>
        </table>

        <div class="pay-invoice align-right">
          <span class="margin bold">Uplacivanje fakture </span> <br />
          <label for="iznos" class="margin">
            Iznos:
          </label>
          <input type="number" name="iznos" class="margin" />
          <button>Napravi uplatnicu</button>
        </div>
      </div>
    </div>
  );
};

export default SelectedInvoice;
