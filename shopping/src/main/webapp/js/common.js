function funcI(){ /* 새 글쓰기 폼 가기 */
	location.href="b_insertform.do";
}

function funcD(num,passwd){ /* 게시글 삭제 */
	if(confirm("정말 삭제하시겠습니까?") == true){
		location.href="b_delete.do?num="+num
	}else{
		alert("취소하였습니다.");
	}
}
function funcClickPage(p){
	var pagenum = p;
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();
	
	if(pagesize == null || pagesize =="" ){
		pagesize = 10;
	}
	if(blocksize == null || blocksize ==""){
		blocksize = 10;
	}
	location.href="board.do?pagenum="+ pagenum 
					 +"&pagesize="+ pagesize + "&blocksize="+ blocksize
						+"&sDate="+ sDate +"&eDate="+ eDate;
}


function funcFirst(){ /* 첫 페이지로 가기 */
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	location.href="board.do?pagenum="+ 1 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
					 +"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcPB(){ /* 이전 블록으로 가기 */
	var block = parseInt($('#startBlockPage').val()) - parseInt($('#blockSize').val());
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	if(block < 1) block = 1;
	//alert(block);
	location.href="board.do?pagenum=" + block 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
						+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcP(){  /* 이전 페이지로 가기 */
	var page = parseInt($('#pagenum').val()) -1;
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	if(page < 1) page = 1;
	location.href="board.do?pagenum=" + page 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
						+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcN(){ /* 다음 페이지로 가기 */
	var page = parseInt($('#pagenum').val()) +1;
	var totalPage = parseInt($('#totalPage').val());
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	if(page > totalPage) page = totalPage;
	location.href="board.do?pagenum=" + page 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
						+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcNB(){ /* 다음 블록으로 가기 */
	var block = parseInt($('#endBlockPage').val()) + 1;
	var totalPage = parseInt($('#totalPage').val());
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	if(block > totalPage) block = totalPage;
	//alert(block);
	location.href="board.do?pagenum=" + block 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
					+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcLast(){ /* 마지막 페이지로가기 */
	var lastblock = parseInt($('#totalPage').val());
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	location.href="board.do?pagenum=" + lastblock 
					 +"&pagesize="+ pagesize +"&blocksize="+ blocksize
   					+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcSizeSubmit(){ /* 페이지,블록 레코드 조절 */
	var currentpage = $('#currentPage').val();
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();

	if(pagesize =="" ){
		pagesize = 10;
	}
	if(blocksize ==""){
		blocksize = 10;
	}
	location.href="board.do?pagenum="+ currentpage 
					 +"&pagesize="+ pagesize + "&blocksize="+ blocksize
						+"&sDate="+ sDate +"&eDate="+ eDate;
}

function funcDateSearch(){ /*연도별 검색*/ 
	var currentpage = $('#currentPage').val();
	var pagesize = $('#pageSize').val();
	var blocksize = $('#blockSize').val();
	var sDate = $('#sDateText').val();
	var eDate = $('#eDateText').val();
	
	location.href="board.do?pagenum=" + currentpage 
					 +"&pagesize="+ pagesize + "&blocksize="+ blocksize
					 +"&sDate="+ sDate +"&eDate="+ eDate;

}

