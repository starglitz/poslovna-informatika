const StavkeRow = (props) => {
  return (
    <tr>
      <td>{props.stavka.id}</td>
      <td>{props.stavka.brojStavke}</td>
      <td>{props.stavka.iznos}</td>
      <td>{props.stavka.duznik}</td>
      <td>{props.stavka.svrhaPlacanja}</td>
      <td>{props.stavka.primalac}</td>
    </tr>
  );
};

export default StavkeRow;
