const InvoiceRow = (props) => {
  return (
    <tr>
      <td>{props.invoice.ID}</td>
      <td>{props.invoice.brojFakture}</td>
      <td>{props.invoice.iznosZaPlacanje}</td>
      <td>{props.invoice.poslovnaGodina}</td>
    </tr>
  );
};

export default InvoiceRow;
