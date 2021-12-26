import { Button } from "antd";
import { useEffect, useState } from "react";
import { Dropdown, Toast } from "react-bootstrap";
import { InvoiceService } from "../../service/InvoiceService";
import { PartneriService } from "../../service/PartneriService";

const DownloadPdf = () => {
  const [partneri, setPartneri] = useState([]);
  const [selectedPartner, setSelectedPartner] = useState({});

  useEffect(() => {
    fetchPartneri();
  }, []);

  async function fetchPartneri() {
    const response = await PartneriService.fetchPartneri();
    setPartneri(response);
  }

  async function generatePdf() {
    if (selectedPartner.id == null) {
      toggleShowToast(true);
    } else {
      await InvoiceService.getPdf(selectedPartner);
    }
  }

  const [showToast, setShowToast] = useState(false);

  const toggleShowToast = (show) => {
    setShowToast(show);
  };

  return (
    <div class="download-pdf-div">
      <Dropdown class="margin">
        <Dropdown.Toggle variant="success" id="dropdown-basic">
          Izaberite poslovnog partnera
        </Dropdown.Toggle>

        <Dropdown.Menu>
          {partneri.map((partner) => (
            <Dropdown.Item onClick={() => setSelectedPartner(partner)}>
              {partner.naziv}
            </Dropdown.Item>
          ))}
        </Dropdown.Menu>
      </Dropdown>
      <br></br>
      <Button onClick={generatePdf}>
        Download Knjiga Izlaznih Faktura PDF
      </Button>

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
          <Toast.Body>Morate izabrati poslovnog partnera ! :(</Toast.Body>
        </Toast>
      </div>
    </div>
  );
};

export default DownloadPdf;
