<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/purecss@3.0.0/build/pure-min.css">
		<link rel="stylesheet" href="/test/css/buttons.css">
		<meta charset="UTF-8">
		<title>Booking Room Update</title>
	</head>
	<body style="padding: 15px">
		<!-- 修改Room -->
		<form class="pure-form" action="/test/room/update" method="post">
			<fieldset>
				<legend>Room Update</legend>
				Room Id: <input type="text" id="bookingId" name="bookingId" value="${ room.bookingId }" readonly /><p>
				Room Name: <input type="text" id="roomName" name="roomName" value="${ room.roomName }" placeholder="請輸入room name" required /><p>
				<button type="submit" class="pure-button pure-button-primary">修改BookingRoom</button>
			</fieldset>
		</form>
		
		
	</body>
</html>>