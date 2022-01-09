import { Button } from "antd";
import { useState } from "react";
import { DnevnoStanjeService } from "../../service/DnevnoStanjeService";

const UploadFile = () => {
  const [file, setFile] = useState({});

  async function uploadDnevnoStanje() {
    console.log(file);
    await DnevnoStanjeService.uploadDnevnoStanje(file);
  }

  const onFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  return (
    <div className="download-pdf-div">
      <label for="jsonFajl" className="import">
        Import podataka dnevnog stanja
      </label>
      <br></br>
      <br></br>
      <input type="file" name="jsonFajl" onChange={onFileChange}></input>
      <Button onClick={uploadDnevnoStanje}>Importuj dnevno stanje</Button>
    </div>
  );
};

export default UploadFile;
