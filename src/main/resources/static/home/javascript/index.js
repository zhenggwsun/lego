$(document).ready(function() {

//数据加载
    //新品上市
    $.get("/home/product/queryNewList",function(data,status){
        if (data.success == true && data.data != null){
            var itemList = "";
            for(var i=0; i < data.data.length; i++){

                var item ="<div class='item'>"+
                    "<div class='product-thumb transition'>"+
                    "<div class='image product-imageblock'> <a href='/home/product/queryProduct?id="+data.data[i].id+"'><img src='/uploaded/"+data.data[i].photo+"' alt="+data.data[i].productName+" title="+data.data[i].productName+" class='img-responsive' /> </a>"+
                    /*"<div class='button-group'>"+
                    "<button type='button' class='addtocart-btn' >Add To Cart</button>"+
                    "</div>"+*/
                    "</div>"+
                    "<div class='caption product-detail'>"+
                    "<h4 class='product-name'><a href='#'>"+data.data[i].productName+"</a></h4>"+
                    "<span class='price-new'>"+"￥"+data.data[i].price+"</span> <span class='price-old'>"+"￥"+(data.data[i].price)*1.2+"</span>"+
                    "</div>"+
                    "</div>"+
                    "</div>";
                itemList += item;
            }
            $('#latest-slidertab').html(itemList);
        }

        $('#latest-slidertab').owlCarousel({
            items: 5,
            navigation: true,
            pagination: false,
            itemsDesktop : [1199, 3],
            itemsDesktopSmall : [979, 2],
            itemsTablet : [768, 2],
            itemsTabletSmall : false,
            itemsMobile : [479, 1]
        });
    });
    //爆款推荐
    $.get("/home/product/queryHotSellList",function(data,status){
        if (data.success == true && data.data != null){
            var itemList = "";
            for(var i=0; i < data.data.length; i++){

                var item ="<div class='item'>"+
                    "<div class='product-thumb transition'>"+
                    "<div class='image product-imageblock'> <a href='/home/product/queryProduct?id="+data.data[i].id+"'><img src='/uploaded/"+data.data[i].photo+"' alt="+data.data[i].productName+" title="+data.data[i].productName+" class='img-responsive' /> </a>"+
                    /*"<div class='button-group'>"+
                    "<button type='button' class='addtocart-btn' >Add To Cart</button>"+
                    "</div>"+*/
                    "</div>"+
                    "<div class='caption product-detail'>"+
                    "<h4 class='product-name'><a href='#'>"+data.data[i].productName+"</a></h4>"+
                    "<span class='price-new'>"+"￥"+data.data[i].price+"</span> <span class='price-old'>"+"￥"+(data.data[i].price)*1.2+"</span>"+
                    "</div>"+
                    "</div>"+
                    "</div>";
                itemList += item;
            }
            $('#content #feature-slider').html(itemList);
        }

        $('#content #feature-slider').owlCarousel({
            items: 5,
            navigation: true,
            pagination: false,
            itemsDesktop : [1199, 3],
            itemsDesktopSmall : [979, 2],
            itemsTablet : [768, 2],
            itemsTabletSmall : false,
            itemsMobile : [479, 1]
        });
    });
    //当季热卖
    $.get("/home/product/queryRecommendList",function(data,status){
        if (data.success == true && data.data != null){
            var itemList = "";
            for(var i=0; i < data.data.length; i++){

                var item ="<div class='item'>"+
                    "<div class='product-thumb transition'>"+
                    "<div class='image product-imageblock'> <a href='/home/product/queryProduct?id="+data.data[i].id+"'><img src='/uploaded/"+data.data[i].photo+"' alt="+data.data[i].productName+" title="+data.data[i].productName+" class='img-responsive' /> </a>"+
                    /*"<div class='button-group'>"+
                    "<button type='button' class='addtocart-btn' >Add To Cart</button>"+
                    "</div>"+*/
                    "</div>"+
                    "<div class='caption product-detail'>"+
                    "<h4 class='product-name'><a href='#'>"+data.data[i].productName+"</a></h4>"+
                    "<span class='price-new'>"+"￥"+data.data[i].price+"</span> <span class='price-old'>"+"￥"+(data.data[i].price)*1.2+"</span>"+
                    "</div>"+
                    "</div>"+
                    "</div>";
                itemList += item;
            }
            $('#content #special-slider').html(itemList);
        }

        $('#content #special-slider').owlCarousel({
            items: 5,
            navigation: true,
            pagination: false,
            itemsDesktop : [1199, 3],
            itemsDesktopSmall : [979, 2],
            itemsTablet : [768, 2],
            itemsTabletSmall : false,
            itemsMobile : [479, 1]
        });
    });
});






