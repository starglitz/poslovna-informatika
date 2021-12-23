const InvoiceRow = (props) => {
  return (
    <tr>
      <td>{props.invoice.id}</td>
      <td>{props.invoice.brojFakture}</td>
      <td>{props.invoice.iznosZaPlacanje}</td>
    </tr>
  );
};

export default InvoiceRow;
