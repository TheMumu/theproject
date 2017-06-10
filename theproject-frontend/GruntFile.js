module.exports = function(grunt) {

  grunt.initConfig({
    pkg: grunt.file.readJSON('package.json'),
    concat: {
      options: {
        separator: ';'
      },
      js: {
        src: ['assets/**/*.js'],
        dest: 'target/assets/js/<%= pkg.name %>.js'
      },
      css: {
        src: ['assets/**/*.css'],
        dest: 'target/assets/css/<%= pkg.name %>.css'
      }
    },
    uglify: {
      options: {
        banner: '/*! <%= pkg.name %> <%= grunt.template.today("dd-mm-yyyy") %> */\n'
      },
      dist: {
        files: {
          'target/assets/js/<%= pkg.name %>.min.js': ['<%= concat.js.dest %>']
        }
      }
    },
    copy: {
      main: {
        expand: true,
        flatten: true,
        src: 'assets/templates/*',
        dest: 'target/assets/templates/',
      },
      sec: {
        expand: true,
        flatten: true,
        src: 'assets/static/*',
        dest: 'target/assets/static/',
      },
      third: {
        expand: true,
        flatten: true,
        src: 'assets/json/*',
        dest: 'target/assets/json/',
      }
    },
    jshint: {
      files: ['Gruntfile.js', 'assets/**/*.js'],
      options: {
        // options here to override JSHint defaults
        globals: {
          jQuery: true,
          console: true,
          module: true,
          document: true
        }
      }
    },
    watch: {
      files: ['<%= jshint.files %>', 'assets/**/*'],
      tasks: ['jshint']
    }
  });

  grunt.loadNpmTasks('grunt-contrib-uglify');
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.loadNpmTasks('grunt-contrib-watch');
  grunt.loadNpmTasks('grunt-contrib-concat');
  grunt.loadNpmTasks('grunt-contrib-copy');


  grunt.registerTask('default', ['jshint', 'concat', 'uglify', 'copy']);

};