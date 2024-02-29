async function uploadFile(filePath){
    document.getElementById("btnsubmit").disabled= true;
    const formData = new FormData()
    formData.append("file", filePath.files[0])
    var urlUpload = 'http://localhost:8080/api/public/upload-file';
    // var urlUpload= "https://hotelspring.up.railway.app/api/public/upload-file";
    const res = await fetch(urlUpload, {
        method: 'POST',
        body: formData
    });
    if (res.status < 300) {
        var linkfile = await res.text();
        document.getElementById("duongdananh").value = linkfile;
        document.getElementById("btnsubmit").disabled= false;
    }
    else{
        document.getElementById("btnsubmit").disabled= false;
    }
}
