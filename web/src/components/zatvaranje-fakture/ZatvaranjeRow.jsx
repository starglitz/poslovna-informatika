const ZatvaranjeRow = (props) => {
  return (
    <tr>
      <td>{props.zatvaranje.id}</td>
      <td>{props.zatvaranje.iznos}</td>
      <td>{props.zatvaranje.faktura.id}</td>
      <td>{props.zatvaranje.stavkaIzvoda.id}</td>
    </tr>
  );
};

export default ZatvaranjeRow;
