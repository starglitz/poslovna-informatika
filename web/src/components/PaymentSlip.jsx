const PaymentSlip = () => {
  return (
    <div>
      <div class="payment-slip padding">
        <div class="align-left bold">Stavka izvoda</div> <br />
        <div class="payment-slip-content block">
          <table class="payment-slip-table align-left">
            <tr>
              <td>
                <label for="duznik" class="align-left">
                  Duznik
                </label>
                <br />
                <input
                  type="text"
                  name="duznik"
                  class="payment-slip-field"
                  defaultValue="Unosi korisnik"
                />
              </td>
              <td>
                <label for="racunDuznika" class="align-left">
                  Racun duznika
                </label>
                <br />
                <input
                  type="text"
                  name="racunDuznika"
                  class="payment-slip-field"
                  defaultValue="Unosi korisnik"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="primalac" class="align-left">
                  Primalac
                </label>
                <br />
                <input
                  type="text"
                  name="primalac"
                  class="payment-slip-field"
                  defaultValue="Naziv preduzeca iz fakture"
                />
              </td>
              <td>
                <label for="racunPrimaoca" class="align-left">
                  Racun primaoca
                </label>
                <br />
                <input
                  type="text"
                  name="racunPrimaoca"
                  class="payment-slip-field"
                  defaultValue="48384983874193"
                />
              </td>
            </tr>
            <tr>
              <td>
                <label for="iznos" class="align-left">
                  iznos
                </label>
                <br />
                <input
                  type="text"
                  name="iznos"
                  class="payment-slip-field"
                  defaultValue="Prethodno uneo korisnik"
                />
              </td>
              <td>
                <div>
                  <label for="model" class="align-left">
                    Model
                  </label>
                  <br />
                  <input
                    type="text"
                    name="model"
                    class="payment-slip-field"
                    defaultValue="98"
                  />
                </div>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <label for="pozivNaBroj" class="align-left">
                  Poziv na broj
                </label>
                <br />
                <input
                  type="text"
                  name="pozivNaBroj"
                  class="payment-slip-field"
                  defaultValue="324234234"
                />
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <button class="margin pay-button"> Uplati </button>
              </td>
            </tr>
          </table>
        </div>
      </div>
    </div>
  );
};

export default PaymentSlip;
