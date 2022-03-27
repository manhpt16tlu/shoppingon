
const form = document.getElementById("register-form");
const name = document.getElementById("input-name");
const email = document.getElementById("input-email");
const phone = document.getElementById("input-phone");
const pass = document.getElementById("input-pass");
const rePass = document.getElementById("input-repass");

const inputs = document.querySelectorAll("input");
inputs.forEach((element) => {
    element.addEventListener('focus', () => {
      element.parentElement.classList.remove("border","border-3","border-danger","rounded-4");
    });
  });

const showError = (input) => {
    const formControl = input.parentElement;
    formControl.classList.add("border","border-3","border-danger","rounded-4");
};
const checkLength = (input, min) => {
    if (input.value.length < min) {
	showError(input);
	return false;
    }
    return true;
};
const checkMatch = (input1,input2)=>{
    if(input1.value != input2.value)
    {
	showError(rePass);
	return false;
    }
    return true;
}

function checkForm() {
    if(!checkLength(pass,8) || !checkMatch(pass,rePass))
	return false;

}
