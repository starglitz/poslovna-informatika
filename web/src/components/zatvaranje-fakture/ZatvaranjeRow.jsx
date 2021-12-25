const ZatvaranjeRow = (props) => {
  return (
    <tr>
      <td>{props.zatvaranje.id}</td>
      <td>{props.zatvaranje.iznos}</td>
    </tr>
  );
};

export default ZatvaranjeRow;
