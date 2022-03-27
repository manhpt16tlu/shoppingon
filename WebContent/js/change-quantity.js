/* event change quantity */
const inputQuantity = document.querySelectorAll('.inputQuantity');
const inputTotal = document.querySelectorAll('.inputTotal');
inputQuantity.forEach((element,index) => {
  element.addEventListener('change', () => {
    element.parentElement.submit();
  });
});
