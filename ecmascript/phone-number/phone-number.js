export default class PhoneNumber {
  constructor(phoneNumber) {
	this.phoneNumber = phoneNumber.replace(/[\(\)\. \-]/g, "")
  }

  number() {
	const match = this.phoneNumber.match(/^1?(\d{10})$/);
	return match ? match[1] : null
  }
}
