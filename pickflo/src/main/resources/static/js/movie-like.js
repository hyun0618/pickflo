/*
 * like.html 
 */

document.addEventListener('DOMContentLoaded', function() {
	
	bindPosterImageClickEvent();
	
	const startTime = Date.now();
	const userId = parseInt(document.getElementById('userId').value);
	let userGroup = (userId % 2 === 0) ? 'B' : 'A';
	
	window.addEventListener('beforeunload', function() {
        const endTime = Date.now();
        const timeSpentSeconds = Math.floor((endTime - startTime) / 1000);  // 페이지에 머문 시간(초)
		const activityTimestamp = new Date().toISOString();  
		
        saveUserData(userGroup, window.location.pathname, timeSpentSeconds, activityTimestamp);
    });
    
    function saveUserData(userGroup, pageName, timeSpentSeconds, activityTimestamp) {
        const userData = {
			userId: userId,
            userGroup: userGroup,
            pageName: pageName,
            timeSpentSeconds: timeSpentSeconds,
            activityTimestamp: activityTimestamp  
        };
     

        // 서버에 POST 요청
        axios.post('/pickflo/api/user-statistics/saveUserData', userData)
            .then(response => {
                console.log('User data saved successfully:', response.data);
            })
            .catch(error => {
                console.error('Error saving user data:', error);
            });
    }
	
});
