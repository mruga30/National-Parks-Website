<!DOCTYPE HTML>
<html>

<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Catamaran:wght@800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@300;700&family=Roboto+Mono&display=swap" rel="stylesheet">
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/masterStyling.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/html/ReviewPages/styling/insertStyling.css">
</head>

<body>
    <nav class="navbar navbar-expand-sm bg-primary navbar-dark">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/index.html">White Sands National Park</a>
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/ReviewList">Display Reviews</a>
            </li>
            <li class="nav-item">
                    <a class="nav-link disabled" href="${pageContext.request.contextPath}/Review">Add Review</a>
            </li>
        </ul>
    </nav>
    <div class="containter">
        <div class="row banner">
            <div class="col banner-text">
                Let us know <br> what you think
            </div>
        </div>

        <div class="row divider"></div>

        <div class="row">
            <div class="col left-col">
                <p class="content-header">Your opinion matters</p>
                <p class="content-body">We would love to hear about your experience at White Sands National Park.
                    First start off by telling us your name and giving your review a title.
                    Then get descriptive and tell us all about what you liked, disliked or were indifferent about during your trip.
                    After that rate your experience and tell us if you would recommend White Sands National Park to a friend.
                </p>
            </div>
            <div class="col right-col">
                <form name="addReview" action ="${pageContext.request.contextPath}/Review" method="post">
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" name="firstName" class="form-control" id="firstName"
                            placeholder="Enter first name...">
                    </div>

                    <div class="form-group">
                        <label for="reviewTitle">Review Title:</label>
                        <input type="text" name="reviewTitle" class="form-control" maxlength="100" id="reviewTitle"
                            placeholder="Max 100 characters...">
                    </div>

                    <div class="form-group">
                        <label for="reviewBody">Review Content:</label>
                        <textarea class="form-control" name="reviewBody" maxlength="2000" id="reviewBody" rows="3"
                            placeholder="Max 6000 characters..."></textarea>
                    </div>

                    <div class="form-group">
                        <label for="rating">How would you rate your experience?</label>
                        <select name="rating" class="form-control" id="sel1">
                            <option value="1">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <div>
                            <p>Would you recommend this park to a friend? </p>
                        </div>
                        <div>
                            <input type="radio" name="recommendation" id="wouldRecommend" checked value="1">
                            <label class="radio-inline">Yes</label>

                            <input type="radio" name="recommendation" id="wouldNotRecommend" value="2">
                            <label class="radio-inline">No</label>
                        </div>
                    </div>

                    <input type="submit" value="Submit" class="btn btn-primary"/>
                    <input type ="hidden" name="action" value="add"/>
                </form>
            </div>
        </div>

        <div class="divider"></div>
        <div class="divider"></div>
        <div class="divider"></div>

        <div class="footer">
            <a href="https://www.nps.gov/whsa/index.htm">National Park Service Website</a> |
            Made with ❤️ by Where's My Char?
        </div>
    </div>
</body>
</html>