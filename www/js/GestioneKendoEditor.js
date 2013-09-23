// JavaScript Document
$(document).ready(function() {
                    // create Editor from textarea HTML element with default set of tools
                    $("#editor").kendoEditor({
                        tools: [
                            "bold",
                "italic",
                "underline",
                "strikethrough",
                "foreColor",
                "justifyLeft",
                "justifyCenter",
                "justifyRight",
                "justifyFull",
                "insertUnorderedList",
                "insertOrderedList",
                "createLink",
                "unlink",
                /*"insertImage",*/
                        ],
                        imageBrowser: {
                           messages: {
                            dropFilesHere: "Drop files here"
                           },
                           transport: {
                                read: "/kendo/service/ImageBrowser/Read",
                                destroy: {
                                    url: "/kendo/service/ImageBrowser/Destroy",
                                    type: "POST"
                                },
                                create: {
                                    url: "/kendo/service/ImageBrowser/Create",
                                    type: "POST"
                                },
                                thumbnailUrl: "/kendo/service/ImageBrowser/Thumbnail",
                                uploadUrl: "/kendo/service/ImageBrowser/Upload",
                                imageUrl: "/kendo/service/ImageBrowser/images/{0}"
                           },
						   path: "/myInitialPath/"
                        }
                    });
                });