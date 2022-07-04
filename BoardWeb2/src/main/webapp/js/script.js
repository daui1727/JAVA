function CheckSession() {
			if (sessionStorage.getItem("id") == null) {
				window.location = "login.jsp";
			}
		}

		setInterval(CheckSession(), 100);
