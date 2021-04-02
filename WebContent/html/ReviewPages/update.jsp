<!DOCTYPE HTML>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&family=Roboto+Mono&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/masterStyling.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/updateStyling.css">
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">White Sands National Park</a>
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/html/ReviewPages/insert.jsp">Add Review</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/ReviewList">Display Reviews</a>
            </li>
        </ul>
    </nav>
    <div class="containter">
        <div class="row banner banner-gradient">
            <div class="col banner-text">
                Want to <br> make a change?
            </div>
        </div>

        <div class="row divider"></div>

        <div class="row">
            <div class="col left-col">
                <p class="content-header">Here's where you can edit or delete your review.</p>
                <p class="content-body">Lorem ipsum dolor sit amet, consectetur adipiscing elit. 
                    Maecenas vitae pharetra justo, eget dictum ipsum. 
                    Mauris iaculis volutpat suscipit. Nullam efficitur est massa, in fermentum massa tempor sed. 
                    Mauris malesuada tempus orci, id porttitor neque. Phasellus posuere massa eget suscipit ullamcorper. </p>

            </div>
            
            <div class="col right-col">
                <form name="updateForm" action="${pageContext.request.contextPath}/Review" method="post">
                    <div class="form-group">
                        <label for="firstName">Full Name:</label>
                        <input type="text" name="firstName" class="form-control" id="firstName"
                            value="${review.userName}" disabled>
                    </div>

                    <div class="form-group">
                        <label for="reviewTitle">Review Title:</label>
                        <input type="text" name="reviewTitle" class="form-control" maxlength="100" id="reviewTitle"
                            value="${review.reviewTitle}">
                    </div>

                    <div class="form-group">
                        <label for="reviewBody">Review Content:</label>
                        <textarea class="form-control" name="reviewBody" maxlength="2000" id="reviewBody" rows="3"
                            placeholder="${review.reviewBody}"></textarea>
                    </div>

                    <div class="form-group">
                        <label for="rating">How would you rate your experience?</label>
                        <select name="rating" class="form-control" id="sel1">
                            <option value="1" ${review.rating==1 ? 'selected' : '' }>1</option>
                            <option value="2" ${review.rating==2 ? 'selected' : '' }>2</option>
                            <option value="3" ${review.rating==3 ? 'selected' : '' }>3</option>
                            <option value="4" ${review.rating==4 ? 'selected' : '' }>4</option>
                            <option value="5" ${review.rating==5 ? 'selected' : '' }>5</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <div>
                            <p>Would you recommend this park to a friend? </p>
                        </div>
                        <div>
                            <input type="radio" name="recommendation" id="wouldRecommend" value="1"
                                ${review.recommendation==1 ? 'checked' : '' }>
                            <label class="radio-inline">Yes</label>

                            <input type="radio" name="recommendation" id="wouldNotRecommend" value="2"
                                ${review.recommendation==2 ? 'checked' : '' }>
                            <label class="radio-inline">No</label>
                        </div>
                    </div>

                    <input type="hidden" name="review_id" value="${review.reviewId}"><br>
                    <input type="submit" name="action" value="Update" class="btn btn-primary"/>
					<input type="submit" name="action" value="Delete" class="btn btn-danger"/>
                </form>
            </div>
        </div>

    </div>
    <div class="row divider"></div>
    <div class="row divider"></div>
    <div class="row divider"></div>

    <div class="footer">
        <a href="https://www.nps.gov/whsa/index.htm">National Park Service Website</a> |
        Made with ❤️ by Where's My Char?
    </div>
</body>

</html>