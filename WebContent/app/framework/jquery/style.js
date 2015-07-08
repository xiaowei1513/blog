//首页图片 
+function ($) {
'use strict';

  // CAROUSEL CLASS DEFINITION
  // =========================
var defaultColor=['rgb(6, 13, 18)','rgb(240, 240, 240)','rgb(165, 204, 232)','rgb(97, 2, 3)','rgb(95, 60, 46)'];
  var CarouselMainBox = function (element, options) {
    this.$element    = $(element)
    this.$indicators = this.$element.find('.carousel-indicators')
    this.options     = options
    this.paused      =
    this.sliding     =
    this.interval    =
    this.$active     =
    this.$items      = null

    this.options.pause == 'hover' && this.$element
      .on('mouseenter', $.proxy(this.pause, this))
      .on('mouseleave', $.proxy(this.cycle, this))
  }

  CarouselMainBox.DEFAULTS = {
    interval: 5000,
    pause: 'hover',
    wrap: true
  }

  CarouselMainBox.prototype.cycle =  function (e) {
    e || (this.paused = false)
    this.interval && clearInterval(this.interval)
    this.options.interval  && !this.paused && (this.interval = setInterval($.proxy(this.next, this), this.options.interval))
    return this
  }

  CarouselMainBox.prototype.getActiveIndex = function () {
    this.$active = this.$element.find('.item.active')
    this.$items  = this.$active.parent().children()
    return this.$items.index(this.$active)
  }

  CarouselMainBox.prototype.to = function (pos) {
    var that        = this
    var activeIndex = this.getActiveIndex()

    if (pos > (this.$items.length - 1) || pos < 0) return

    if (this.sliding)       return this.$element.one('slid.bs.carousel', function () { that.to(pos) })
    if (activeIndex == pos) return this.pause().cycle()

    return this.slide(pos > activeIndex ? 'next' : 'prev', $(this.$items[pos]))
  }

  CarouselMainBox.prototype.pause = function (e) {
    e || (this.paused = true)
    if (this.$element.find('.next, .prev').length && $.support.transition) {
      this.$element.trigger($.support.transition.end)
      this.cycle(true)
    }

    this.interval = clearInterval(this.interval)

    return this
  }

  CarouselMainBox.prototype.next = function () {
    if (this.sliding){
    	return;
    } else {
    	return this.slide('next');
    }
  }

  CarouselMainBox.prototype.prev = function () {
    if (this.sliding) return
    return this.slide('prev')
  }

  CarouselMainBox.prototype.slide = function (type, next) {
	  if (this.$indicators.length) {
	      this.$indicators.find('.active').removeClass('active')
	      this.$element.one('slid.bs.carousel', function () {
	    	 // var index =$(that.$indicators.children()[that.getActiveIndex()]).context.dataset.slideTo;
	    	  //var oDiv = document.getElementById('main-cotent-side-box');
	    	 // oDiv.style.background =  defaultColor[index]; //设置其他浏览器
           // oDiv.style.filter = 'alpha(opacity:'+0+')'; //设置IE透明度
           // oDiv.style.opacity =  0.2; //设置其他浏览器
	    	  var $nextIndicator = $(that.$indicators.children()[that.getActiveIndex()])
	    	  $nextIndicator && $nextIndicator.addClass('active');
	      })
	    }
	    var $active   = this.$element.find('.item.active')
	    var $next     = next || $active[type]()
	    var isCycling = this.interval
	    var direction = type == 'next' ? 'left' : 'right'
	    var fallback  = type == 'next' ? 'first' : 'last'
	    var that      = this

	    if (!$next.length) {
	      if (!this.options.wrap) return
	      $next = this.$element.find('.item')[fallback]()
	    }

	    if ($next.hasClass('active')) return this.sliding = false

	    var e = $.Event('slide.bs.carousel', { relatedTarget: $next[0], direction: direction })
	    this.$element.trigger(e)
	    if (e.isDefaultPrevented()) return

	    this.sliding = true

	    isCycling && this.pause()
	    if (2<1/*$.support.transition && this.$element.hasClass('slide')*/) {
	        $next.addClass(type)
	        $next[0].offsetWidth // force reflow
	        $active.addClass(direction)
	        $next.addClass(direction)
	        $active.one($.support.transition.end, function () {
	          $next.removeClass([type, direction].join(' ')).addClass('active')
	          $active.removeClass(['active', direction].join(' '))
	          that.sliding = false
	          setTimeout(function () { that.$element.trigger('slid.bs.carousel') }, 0)
	        }).emulateTransitionEnd($active.css('transition-duration').slice(0, -1) * 1000)
	    } else {
	      $active.removeClass('active')
	      $next.addClass('active')
	      this.sliding = false
	      this.$element.trigger('slid.bs.carousel')
	    }

	    isCycling && this.cycle()

	    return this
	  }


  // CAROUSEL PLUGIN DEFINITION
  // ==========================

  var old = $.fn.carousel
	
  $.fn.carousel = function (option) {
	 
    return this.each(function () {
      var $this   = $(this)
      var data    = $this.data('bs.carousel')
      var options = $.extend({}, CarouselMainBox.DEFAULTS, $this.data(), typeof option == 'object' && option)
      var action  = typeof option == 'string' ? option : options.slide
      if (!data) $this.data('bs.carousel', (data = new CarouselMainBox(this, options)))
      if (typeof option == 'number') data.to(option)
      else if (action) data[action]()
      else if (options.interval) data.pause().cycle()
    })
  }

  $.fn.carousel.Constructor = CarouselMainBox


  // CAROUSEL NO CONFLICT
  // ====================

  $.fn.carousel.noConflict = function () {
    $.fn.carousel = old
    return this
  }
  $(document).on('click.bs.carousel.data-api', '[data-slide], [data-slide-to]', function (e) {
	    var $this   = $(this), href
	    var $target = $($this.attr('data-target') || (href = $this.attr('href')) && href.replace(/.*(?=#[^\s]+$)/, '')) //strip for ie7
	    var options = $.extend({}, $target.data(), $this.data())
	    var slideIndex = $this.attr('data-slide-to')
	    if (slideIndex) options.interval = false

	    $target.carousel(options)

	    if (slideIndex = $this.attr('data-slide-to')) {
	      $target.data('bs.carousel').to(slideIndex)
	    }

	    e.preventDefault()
	  })
  $(window).on('load', function () {
    $('[data-ride="carousel"]').each(function () {
      var $carousel = $(this)
      $carousel.carousel($carousel.data())
    })
  })
}(jQuery);