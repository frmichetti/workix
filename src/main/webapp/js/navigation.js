$(document).ready(function () {

    console.info("Navigation Hack")

    var href = document.location.href;

    console.info(href);

    var lastPathSegment = href.substr(href.lastIndexOf('/') + 1);

    console.info(lastPathSegment);

    var compareString = lastPathSegment.replace('#', '');

    console.info("compare String -> " + compareString);

    switch (compareString) {

        <!-- fix me -->

        case "index.xhtml":
        case "index.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(1)").toggleClass("active");
            break;

        case "jobs.xhtml":
        case "jobs.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(2)").toggleClass("active");
            break;

        case "post-a-job.xhtml":
        case "post-a-job.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(3)").toggleClass("active");
            break;
        case "candidates.xhtml":
        case "candidates.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(4)").toggleClass("active");
            break;

        case "post-a-resume.xhtml":
        case "post-a-resume.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(5)").toggleClass("active");
            break;

        case "about.xhtml":
        case "about.xhtml?faces-redirect=true":
            $("body > div > div > div.fm-container > div > ul > li:nth-child(6)").toggleClass("active");
            break;

    }


});
